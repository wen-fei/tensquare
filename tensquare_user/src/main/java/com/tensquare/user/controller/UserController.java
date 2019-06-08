package com.tensquare.user.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Autowired
	private JwtUtil jwtUtil;


	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Result login(@PathVariable String mobile, @PathVariable String password) {
		User user = userService.findByMobileAndPassword(mobile, password);

		if (user != null) {
			String token = jwtUtil.createJWT(user.getId(), user.getNickname(), "user");
			Map<String, String> map = new HashMap<>(3);
			map.put("token", token);
			map.put("name", user.getNickname());
			map.put("avatar", user.getAvatar());
			return new Result(true, StatusCode.OK, "登录成功", map);
		} else {
			return new Result(true, StatusCode.LOGINERROR, "用户名或密码错误");
		}
	}

	/**
	 * 用户注册
	 */
	@RequestMapping(value = "/register/{code}", method = RequestMethod.POST)
	public Result register(@RequestBody User user, @PathVariable String code) {
		String checkcodeRedis = (String) redisTemplate.opsForValue().get("smscode_" + user.getMobile());
		if (checkcodeRedis != null || checkcodeRedis.isEmpty()) {
			return new Result(false, StatusCode.ERROR, "请先获取手机验证码");
		}
		if (code.equals(checkcodeRedis)) {
			return new Result(false, StatusCode.ERROR, "验证码错误");
		}
		userService.add(user);
		return new Result(true, StatusCode.ERROR, "注册成功");
	}

	/**
	 * 发送短信验证码
	 */
	@RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
	public Result sendsms(@PathVariable String mobile) {
		userService.sendSms(mobile);
		return new Result(true, StatusCode.OK, "发送成功");
	}


	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",userService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",userService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<User> pageList = userService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<User>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",userService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param user
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody User user  ){
		userService.add(user);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param user
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody User user, @PathVariable String id ){
		user.setId(id);
		userService.update(user);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * 增加权限验证，必须拥有管理员权限，否则不能删除
	 * 前后端约定，前端请求微服务时需要添加头信息Authorization，内容为Bearer+空格+token
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
//		// 获取头信息
//		String authHeader = httpServletRequest.getHeader("Authorization");
//		if (authHeader == null) {
//			return new Result(false, StatusCode.ACCESSERROR, "权限不足");
//		}
//		if (!authHeader.startsWith("Bearer ")) {
//			return new Result(false, StatusCode.ACCESSERROR, "权限不足");
//		}
//
//		// 提取Token
//		String token = authHeader.substring(7);
//		Claims claims = jwtUtil.parseJWT(token);
//		if (claims == null) {
//			return new Result(false, StatusCode.ACCESSERROR, "权限不足");
//		}
//
//		if (!"admin".equals(claims.get("roles"))) {
//			return new Result(false, StatusCode.ACCESSERROR, "权限不足");
//		}
		Claims claims = (Claims) httpServletRequest.getAttribute("admin_claims");
		if (claims == null) {
			return new Result(false, StatusCode.ACCESSERROR, "无权访问");
		}
		userService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
