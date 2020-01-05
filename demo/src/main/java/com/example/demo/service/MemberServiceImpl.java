package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberMapper")
	private MemberMapper memberMapper;
	
	//직원 목록
	public List<Map<String, Object>> selectMemberList() {
		return memberMapper.selectMemberList();
	}

}
