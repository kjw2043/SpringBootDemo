package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface MemberService {
	/**직원 목록**/
	List<Map<String, Object>> selectMemberList();
}
