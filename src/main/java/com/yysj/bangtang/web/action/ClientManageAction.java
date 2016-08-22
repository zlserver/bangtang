package com.yysj.bangtang.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.bean.Content;
import com.yysj.bangtang.common.QueryEntity;
import com.yysj.bangtang.formbean.QueryClientForm;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.utils.SiteUtils;

@Controller
@RequestMapping(value="/control/client/")
public class ClientManageAction {

	private ClientService clientService;
	
	@RequestMapping(value="list")
	public String list(QueryClientForm formbean,Model model){
		
		List<QueryEntity> qes = new ArrayList<QueryEntity>();
		//附加条件查询
		if( formbean.getQuery()!=null && formbean.getQuery().equalsIgnoreCase(QueryClientForm.QUERY_FLAGE)){
			
		}
		
		Page<Client> page=clientService.getScrollData(qes, formbean.getPageNumber(), formbean.getPageSize());
		
		model.addAttribute("page", page);
		return SiteUtils.getPage("client.list");
	}
	
	public ClientService getClientService() {
		return clientService;
	}
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
}
