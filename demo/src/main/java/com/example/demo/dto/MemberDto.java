package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MemberDto {
	private int idx;
	private String name;
	private String email;
}
