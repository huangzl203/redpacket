package com.redpacket.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.redpack.common.userTree.UserTreeDo;
import com.redpack.utils.ResponseUtils;

public class UserTreeTest {

	@Test
	public void testInitUserTree() {
		//组装树对象
		UserTreeDo userTreeDo = new UserTreeDo();
		userTreeDo.setId(100L);
		userTreeDo.setName("陈一");
		List childRen = new ArrayList();
		for (int i = 1; i < 4; i++) {
			UserTreeDo childTreeDo = new UserTreeDo();
			childTreeDo.setId(100L + i);
			childTreeDo.setName("陈五" + i);

			childRen.add(childTreeDo);
		}
		userTreeDo.setChildren(addChildren(100, 6));
		
		/**
		 * 传回userTree页面
		 *
		 * JSONObject jsonObject = new JSONObject();
		 * jsonObject.put("result", 0);
		 * jsonObject.put("userTree", userDo);
		// 数据传输成功
		ResponseUtils.renderText(response, "UTF-8", jsonObject.toString());
		*/
	}

	public List addChildren(int parent, int leavel) {

		List childRen = new ArrayList();
		leavel--;
		if (leavel > 0) {
			for (int i = 1; i < 4; i++) {
				// int id = parent+10 + i;
				// Random random1 = new Random(100);
				int id = (int) (Math.random() * 1000);
				UserTreeDo childTreeDo = new UserTreeDo();
				childTreeDo.setId(Long.valueOf(id));
				childTreeDo.setName("陈五" + id);
				childTreeDo.setChildren(addChildren(id, leavel));

				childRen.add(childTreeDo);
			}
		}
		return childRen;
	}
}
