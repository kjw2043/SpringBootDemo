package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDto;
import com.example.demo.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberMapper")
	private MemberMapper memberMapper;
	
	public List<Map<String, Object>> selectMemberList() {
		return memberMapper.selectMemberList();
	}

	public List<MemberDto> selectMemberDtoList() {
		List<Map<String, Object>> list = selectMemberList();
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		
		for(Map item : list) {
			/*
			 * MemberDto dto = MemberDto.builder() .name((String)item.get("name"))
			 * .email((String)item.get("email")) .build();
			 */
			MemberDto dto = MemberDto.builder()
					.name((String)item.get("name"))
					.email((String)item.get("email"))
					.build();
		}
		return null;
	}
	
}
