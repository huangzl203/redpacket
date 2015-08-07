package com.redpacket.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.redpack.common.account.IUserService;
import com.redpack.common.account.model.UserDo;

public class UserInfoServiceTest extends BaseTestCase {

	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetParent(){
		long currentUserId = 1;
		UserDo user = userService.getParent(currentUserId);
		Assert.assertNull(user);
	}
}
