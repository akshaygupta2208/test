package com.ayursinfotech.agent.service;

import com.ayursinfotech.agent.beans.dto.AgentDTO;
import com.ayursinfotech.agent.beans.dto.LoginDTO;
import com.ayursinfotech.agent.response.BaseResponse;

public interface AgentService {

	BaseResponse editAgentProfile(AgentDTO agentDTO);

	BaseResponse login(LoginDTO login);

	BaseResponse ping();

	BaseResponse registerAgent(AgentDTO agentDTO);

	BaseResponse changePassword(LoginDTO login);

	BaseResponse forgotPassword(LoginDTO login);

	BaseResponse resetPassword(String mobileNo, String newPassword,
			String timestamp);

}
