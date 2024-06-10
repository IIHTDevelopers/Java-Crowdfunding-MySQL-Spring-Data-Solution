package com.crowdfunding.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.crowdfunding.dto.InvestmentDTO;
import com.crowdfunding.dto.ProjectDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MasterData {

	public static ProjectDTO getProjectDTO() {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(1L);
		projectDTO.setName("Revolutionizing Crowdfunding");
		projectDTO.setDescription("A platform to connect innovators with investors globally.");
		projectDTO.setGoalAmount(50000.00);
		projectDTO.setAmountRaised(10000.00);
		projectDTO.setInvestments(Arrays.asList(getInvestmentDTO()));
		return projectDTO;
	}

	public static List<ProjectDTO> getProjectDTOList() {
		List<ProjectDTO> projectDTOList = new ArrayList<>();
		projectDTOList.add(getProjectDTO());
		return projectDTOList;
	}

	public static Page<ProjectDTO> getProjectDTOPage(int page, int size) {
		List<ProjectDTO> projectDTOList = getProjectDTOList();
		PageRequest pageRequest = PageRequest.of(page, size);
		return new PageImpl<>(projectDTOList, pageRequest, projectDTOList.size());
	}

	public static InvestmentDTO getInvestmentDTO() {
		InvestmentDTO investmentDTO = new InvestmentDTO();
		investmentDTO.setId(1L);
		investmentDTO.setAmount(1000.00);
		investmentDTO.setInvestorName("Alice Wonderland");
		investmentDTO.setProjectId(1L);
		return investmentDTO;
	}

	public static List<InvestmentDTO> getInvestmentDTOList() {
		List<InvestmentDTO> investmentDTOList = new ArrayList<>();
		investmentDTOList.add(getInvestmentDTO());
		return investmentDTOList;
	}

	public static String asJsonString(Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}