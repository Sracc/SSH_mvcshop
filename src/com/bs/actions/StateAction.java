package com.bs.actions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import com.bs.entity.Search;
import com.bs.entity.State;
import com.bs.entity.User;
import com.bs.service.StateService;
import com.bs.utils.PageContext;
import com.bs.utils.ResultUtils;



@Controller("stateAction")
@Scope("prototype")
public class StateAction extends BaseAction {

	@Resource
	private StateService stateService;
	private State state;

	
	public String addInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "add_input";
	}
	public String add(){
		stateService.add(state);
		return "add_success";
	}

	public String delete(){
		stateService.delete(stateService.findById(state.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] stateIds = request.getParameterValues("stateCheckbox");
		if(stateIds!=null){
			for (int i = 0; i < stateIds.length; i++) {
				stateService.delete(stateService.findById(Integer.parseInt(stateIds[i])));
			}
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("state", stateService.findById(state.getId()));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_state_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("state", stateService.findById(state.getId()));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		stateService.update(state);
		stateService.sessionFlush();
		stateService.sessionRefresh(state);
		return "showlist";
	}
	
	public String get(){
		return "get";
	}

	public String list(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int pageNo = PageContext.getPage().getPageNo();
		int pageSize = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		User user = (User) request.getSession().getAttribute("login_user");
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("search", search);
		PageContext.getPage().setPageNo(pageNo);
		PageContext.getPage().setPageSize(pageSize);
		request.setAttribute("stateList", stateService.search(search));
		return "list";
	}

	public Object getModel() {
		if(state == null){
			state = new State();
		}
		return state;
	}

	
}

