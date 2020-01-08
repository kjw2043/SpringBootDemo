package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.MemberDto;

public interface MemberService {
	List<Map<String, Object>> selectMemberList();
	List<MemberDto> selectMemberDtoList();
}
