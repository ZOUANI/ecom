package ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.User;
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Component
public class UserConverter extends AbstractConverter<User, UserVo> {
	@Autowired
	private RoleConverter roleConverter;
	private boolean authority;
	@Autowired
	private UserConverter userConverter;
	private boolean superAdmin;
	@Autowired
	private DeliveryTypeConverter deliveryTypeConverter;
	private boolean deliveryType;
	@Autowired
	private CityConverter cityConverter;
	private boolean city;

	public UserConverter() {
		init(true);
	}

	@Override
	public User toItem(UserVo vo) {
		if (vo == null) {
			return null;
		} else {
			User item = new User();
			if(StringUtil.isNotEmpty(vo.getPassword()))
				item.setPassword(vo.getPassword());
			if (StringUtil.isNotEmpty(vo.getEnabled()))
				item.setEnabled(NumberUtil.toBoolean(vo.getEnabled()));
			if (StringUtil.isNotEmpty(vo.getPhoneNumber()))
				item.setPhoneNumber(vo.getPhoneNumber());
			if (StringUtil.isNotEmpty(vo.getLastName()))
				item.setLastName(vo.getLastName());
			if (StringUtil.isNotEmpty(vo.getEmail()))
				item.setEmail(vo.getEmail());
			if (StringUtil.isNotEmpty(vo.getCreated()))
				item.setCreated(DateUtil.parse(vo.getCreated()));
			if (StringUtil.isNotEmpty(vo.getCode()))
				item.setCode(vo.getCode());
			if (StringUtil.isNotEmpty(vo.getFirstName()))
				item.setFirstName(vo.getFirstName());
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));
			if (vo.getAuthorityVo() != null && this.authority)
				item.setAuthority(roleConverter.toItem(vo.getAuthorityVo()));
			if (vo.getSuperAdminVo() != null && this.superAdmin)
				item.setSuperAdmin(userConverter.toItem(vo.getSuperAdminVo()));
			if (vo.getDeliveryTypeVo() != null && this.deliveryType)
				item.setDeliveryType(deliveryTypeConverter.toItem(vo.getDeliveryTypeVo()));
			if (vo.getCityVo() != null && this.city)
				item.setCity(cityConverter.toItem(vo.getCityVo()));

			return item;
		}
	}

	@Override
	public UserVo toVo(User item) {
		if (item == null) {
			return null;
		} else {
			UserVo vo = new UserVo();
			if(StringUtil.isNotEmpty(item.getPassword()))
				vo.setPassword(item.getPassword());

			if (item.getEnabled() != null)
				vo.setEnabled(NumberUtil.toString(item.getEnabled()));
			if (StringUtil.isNotEmpty(item.getPhoneNumber()))
				vo.setPhoneNumber(item.getPhoneNumber());

			if (StringUtil.isNotEmpty(item.getLastName()))
				vo.setLastName(item.getLastName());

			if (StringUtil.isNotEmpty(item.getEmail()))
				vo.setEmail(item.getEmail());

			if (item.getCreated() != null)
				vo.setCreated(DateUtil.formateDate(item.getCreated()));
			if (StringUtil.isNotEmpty(item.getCode()))
				vo.setCode(item.getCode());

			if (StringUtil.isNotEmpty(item.getFirstName()))
				vo.setFirstName(item.getFirstName());

			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));
			if (item.getAuthority() != null && this.authority) {
				roleConverter.init(false);
				vo.setAuthorityVo(roleConverter.toVo(item.getAuthority()));
				roleConverter.init(true);
			}
			if (item.getSuperAdmin() != null && this.superAdmin) {
				userConverter.init(false);
				vo.setSuperAdminVo(userConverter.toVo(item.getSuperAdmin()));
				userConverter.init(true);
			}
			if (item.getDeliveryType() != null && this.deliveryType) {
				deliveryTypeConverter.init(false);
				vo.setDeliveryTypeVo(deliveryTypeConverter.toVo(item.getDeliveryType()));
				deliveryTypeConverter.init(true);
			}
			if (item.getCity() != null && this.city) {
				cityConverter.init(false);
				vo.setCityVo(cityConverter.toVo(item.getCity()));
				cityConverter.init(true);
			}

			return vo;

		}
	}

	public void init(boolean value) {
		authority = value;
		superAdmin = value;
		deliveryType = value;
		city = value;
	}

	public RoleConverter getRoleConverter() {
		return this.roleConverter;
	}

	public void setRoleConverter(RoleConverter roleConverter) {
		this.roleConverter = roleConverter;
	}

	public boolean isAuthority() {
		return this.authority;
	}

	public void setAuthority(boolean authority) {
		this.authority = authority;
	}

	public UserConverter getUserConverter() {
		return this.userConverter;
	}

	public void setUserConverter(UserConverter userConverter) {
		this.userConverter = userConverter;
	}

	public boolean isSuperAdmin() {
		return this.superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	public DeliveryTypeConverter getDeliveryTypeConverter() {
		return this.deliveryTypeConverter;
	}

	public void setDeliveryTypeConverter(DeliveryTypeConverter deliveryTypeConverter) {
		this.deliveryTypeConverter = deliveryTypeConverter;
	}

	public boolean isDeliveryType() {
		return this.deliveryType;
	}

	public void setDeliveryType(boolean deliveryType) {
		this.deliveryType = deliveryType;
	}

	public CityConverter getCityConverter() {
		return this.cityConverter;
	}

	public void setCityConverter(CityConverter cityConverter) {
		this.cityConverter = cityConverter;
	}

	public boolean isCity() {
		return this.city;
	}

	public void setCity(boolean city) {
		this.city = city;
	}
}
