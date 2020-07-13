package ma.zs.generated.ws.rest.provided.facade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import ma.zs.generated.bean.User;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.ws.rest.provided.converter.UserConverter;
import ma.zs.generated.ws.rest.provided.vo.AuthRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("Manages categoryProduct services")
@RestController
@RequestMapping("generated/auth")
public class AuthRest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserConverter userConverter;

	@PostMapping(value = "/login")
	public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) {
		Object result = userService.login(authRequest);
		Map<String, Object> data = new HashMap<>();
		if (result instanceof String) {
			data.put("message", result);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		data.put("message", "Logged in successfully");
		data.put("user", result);
		return ResponseEntity.status(HttpStatus.OK).body(userConverter.toVo((User) result));
	}

}