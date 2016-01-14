package com.koo.myapp.member.dao;

import com.koo.myapp.member.bean.MemberBean;

public interface MemberDao {
	
	public int insertMember(MemberBean memberBean) throws Exception;
}
