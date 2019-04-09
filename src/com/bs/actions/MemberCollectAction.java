package com.bs.actions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import com.bs.entity.Member;
import com.bs.entity.MemberCollect;
import com.bs.entity.Search;
import com.bs.entity.User;
import com.bs.service.GoodsService;
import com.bs.service.MemberCollectService;
import com.bs.service.MemberService;
import com.bs.utils.PageContext;
import com.bs.utils.ResultUtils;



@Controller("memberCollectAction")
@Scope("prototype")
public class MemberCollectAction extends BaseAction {

	@Resource
	private MemberCollectService memberCollectService;
	@Resource
	private MemberService memberService ;
	@Resource
	private GoodsService goodsService ;
	private MemberCollect memberCollect;

	
	public String addInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "add_input";
	}
	public String add(){
		memberCollectService.add(memberCollect);
		return "add_success";
	}

	public String delete(){
		memberCollectService.delete(memberCollectService.findById(memberCollect.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] memberCollectIds = request.getParameterValues("memberCollectCheckbox");
		if(memberCollectIds!=null){
			for (int i = 0; i < memberCollectIds.length; i++) {
				memberCollectService.delete(memberCollectService.findById(Integer.parseInt(memberCollectIds[i])));
			}
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("memberCollect", memberCollectService.findById(memberCollect.getId()));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_memberCollect_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("memberCollect", memberCollectService.findById(memberCollect.getId()));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		memberCollectService.update(memberCollect);
		memberCollectService.sessionFlush();
		memberCollectService.sessionRefresh(memberCollect);
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
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		Member member = (Member) request.getSession().getAttribute("member");
		if("2".equals(user.getRole().getId()+"")&&search.getType().equals("backend")){
			search.setAuthorityName("member");
			search.setAuthorityValue(member.getId()+"");
		}
		PageContext.getPage().setPageNo(pageNo);
		PageContext.getPage().setPageSize(pageSize);
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		return "list";
	}

	public Object getModel() {
		if(memberCollect == null){
			memberCollect = new MemberCollect();
		}
		return memberCollect;
	}

	
}

