package com.bs.actions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import com.bs.entity.CommentMsg;
import com.bs.entity.Goods;
import com.bs.entity.GoodsClassify;
import com.bs.entity.Member;
import com.bs.entity.MemberCollect;
import com.bs.entity.News;
import com.bs.entity.Orders;
import com.bs.entity.Search;
import com.bs.entity.State;
import com.bs.service.CommentMsgService;
import com.bs.service.GoodsClassifyService;
import com.bs.service.GoodsService;
import com.bs.service.MemberCollectService;
import com.bs.service.MemberService;
import com.bs.service.NewsService;
import com.bs.service.OrdersService;
import com.bs.service.StateService;
import com.bs.utils.PageContext;
import com.bs.utils.ResultUtils;



@Controller("siteAction")
@Scope("prototype")
public class SiteAction extends BaseAction {

	@Resource
	private MemberService memberService ;
	@Resource
	private NewsService newsService ;
	@Resource
	private GoodsClassifyService goodsClassifyService ;
	@Resource
	private GoodsService goodsService ;
	@Resource
	private OrdersService ordersService ;
	@Resource
	private CommentMsgService commentMsgService ;
	@Resource
	private MemberCollectService memberCollectService ;
	@Resource
	private StateService stateService ;
	private String url="";
	public String addMemberInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Member member = ResultUtils.copyParams(Member.class, request);
		memberService.add(member);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("member", memberService.findById(search.getId()));
		return "addMemberInput";
	}
	public String addMember(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Member member = ResultUtils.copyParams(Member.class, request);
		memberService.add(member);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("member", memberService.findById(search.getId()));
		return "url";
	}
	
	public String deleteMember(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Member member = ResultUtils.copyParams(Member.class, request);
		memberService.delete(member);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("member", memberService.findById(search.getId()));
		return "url";
	}
	
	public String member(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("member", memberService.findById(search.getId()));
		return "member";
	}
	
	public String members(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "members";
	}
	
	public String addNewsInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		News news = ResultUtils.copyParams(News.class, request);
		newsService.add(news);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("news", newsService.findById(search.getId()));
		return "addNewsInput";
	}
	public String addNews(){
		Search search = ResultUtils.copyParams(Search.class, request);
		News news = ResultUtils.copyParams(News.class, request);
		newsService.add(news);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("news", newsService.findById(search.getId()));
		return "url";
	}
	
	public String deleteNews(){
		Search search = ResultUtils.copyParams(Search.class, request);
		News news = ResultUtils.copyParams(News.class, request);
		newsService.delete(news);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("news", newsService.findById(search.getId()));
		return "url";
	}
	
	public String news(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("news", newsService.findById(search.getId()));
		return "news";
	}
	
	public String newss(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "newss";
	}
	
	public String addGoodsClassifyInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		GoodsClassify goodsClassify = ResultUtils.copyParams(GoodsClassify.class, request);
		goodsClassifyService.add(goodsClassify);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("goodsClassify", goodsClassifyService.findById(search.getId()));
		return "addGoodsClassifyInput";
	}
	public String addGoodsClassify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		GoodsClassify goodsClassify = ResultUtils.copyParams(GoodsClassify.class, request);
		goodsClassifyService.add(goodsClassify);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("goodsClassify", goodsClassifyService.findById(search.getId()));
		return "url";
	}
	
	public String deleteGoodsClassify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		GoodsClassify goodsClassify = ResultUtils.copyParams(GoodsClassify.class, request);
		goodsClassifyService.delete(goodsClassify);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("goodsClassify", goodsClassifyService.findById(search.getId()));
		return "url";
	}
	
	public String goodsClassify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("goodsClassify", goodsClassifyService.findById(search.getId()));
		return "goodsClassify";
	}
	
	public String goodsClassifys(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "goodsClassifys";
	}
	
	public String addGoodsInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Goods goods = ResultUtils.copyParams(Goods.class, request);
		goodsService.add(goods);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("goods", goodsService.findById(search.getId()));
		return "addGoodsInput";
	}
	public String addGoods(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Goods goods = ResultUtils.copyParams(Goods.class, request);
		goodsService.add(goods);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("goods", goodsService.findById(search.getId()));
		return "url";
	}
	
	public String deleteGoods(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Goods goods = ResultUtils.copyParams(Goods.class, request);
		goodsService.delete(goods);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("goods", goodsService.findById(search.getId()));
		return "url";
	}
	
	public String goods(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("goods", goodsService.findById(search.getId()));
		return "goods";
	}
	
	public String goodss(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "goodss";
	}
	
	public String addOrdersInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Orders orders = ResultUtils.copyParams(Orders.class, request);
		ordersService.add(orders);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("orders", ordersService.findById(search.getId()));
		return "addOrdersInput";
	}
	public String addOrders(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Orders orders = ResultUtils.copyParams(Orders.class, request);
		ordersService.add(orders);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("orders", ordersService.findById(search.getId()));
		return "url";
	}
	
	public String deleteOrders(){
		Search search = ResultUtils.copyParams(Search.class, request);
		Orders orders = ResultUtils.copyParams(Orders.class, request);
		ordersService.delete(orders);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("orders", ordersService.findById(search.getId()));
		return "url";
	}
	
	public String orders(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("orders", ordersService.findById(search.getId()));
		return "orders";
	}
	
	public String orderss(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "orderss";
	}
	
	public String addCommentMsgInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		CommentMsg commentMsg = ResultUtils.copyParams(CommentMsg.class, request);
		commentMsgService.add(commentMsg);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("commentMsg", commentMsgService.findById(search.getId()));
		return "addCommentMsgInput";
	}
	public String addCommentMsg(){
		Search search = ResultUtils.copyParams(Search.class, request);
		CommentMsg commentMsg = ResultUtils.copyParams(CommentMsg.class, request);
		commentMsgService.add(commentMsg);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("commentMsg", commentMsgService.findById(search.getId()));
		return "url";
	}
	
	public String deleteCommentMsg(){
		Search search = ResultUtils.copyParams(Search.class, request);
		CommentMsg commentMsg = ResultUtils.copyParams(CommentMsg.class, request);
		commentMsgService.delete(commentMsg);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("commentMsg", commentMsgService.findById(search.getId()));
		return "url";
	}
	
	public String commentMsg(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("commentMsg", commentMsgService.findById(search.getId()));
		return "commentMsg";
	}
	
	public String commentMsgs(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "commentMsgs";
	}
	
	public String addMemberCollectInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		MemberCollect memberCollect = ResultUtils.copyParams(MemberCollect.class, request);
		memberCollectService.add(memberCollect);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("memberCollect", memberCollectService.findById(search.getId()));
		return "addMemberCollectInput";
	}
	public String addMemberCollect(){
		Search search = ResultUtils.copyParams(Search.class, request);
		MemberCollect memberCollect = ResultUtils.copyParams(MemberCollect.class, request);
		memberCollectService.add(memberCollect);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("memberCollect", memberCollectService.findById(search.getId()));
		return "url";
	}
	
	public String deleteMemberCollect(){
		Search search = ResultUtils.copyParams(Search.class, request);
		MemberCollect memberCollect = ResultUtils.copyParams(MemberCollect.class, request);
		memberCollectService.delete(memberCollect);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("memberCollect", memberCollectService.findById(search.getId()));
		return "url";
	}
	
	public String memberCollect(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("memberCollect", memberCollectService.findById(search.getId()));
		return "memberCollect";
	}
	
	public String memberCollects(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "memberCollects";
	}
	
	public String addStateInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		State state = ResultUtils.copyParams(State.class, request);
		stateService.add(state);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("state", stateService.findById(search.getId()));
		return "addStateInput";
	}
	public String addState(){
		Search search = ResultUtils.copyParams(Search.class, request);
		State state = ResultUtils.copyParams(State.class, request);
		stateService.add(state);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("state", stateService.findById(search.getId()));
		return "url";
	}
	
	public String deleteState(){
		Search search = ResultUtils.copyParams(Search.class, request);
		State state = ResultUtils.copyParams(State.class, request);
		stateService.delete(state);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("state", stateService.findById(search.getId()));
		return "url";
	}
	
	public String state(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		request.setAttribute("state", stateService.findById(search.getId()));
		return "state";
	}
	
	public String states(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "states";
	}
	
	public String list(){
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		String strid = request.getParameter("searchid");
		String name = request.getParameter("str");
		Search search = ResultUtils.copyParams(Search.class, request);
		int id = 0;
		if (!"".equals(strid) && strid != null)
			id = Integer.parseInt(strid);

		Search search2 = new Search();
		
		
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		request.setAttribute("search", search);
		request.setAttribute("page", PageContext.getPage());

		PageContext.getPage().setPageSize(ps);
		return "index";
	}

	public String search(){
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("page", PageContext.getPage());
		Search search = ResultUtils.copyParams(Search.class, request);
		Search search2 = new Search();
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("newsList", newsService.search(search));
		request.setAttribute("goodsClassifyList", goodsClassifyService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("ordersList", ordersService.search(search));
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		request.setAttribute("memberCollectList", memberCollectService.search(search));
		request.setAttribute("stateList", stateService.search(search));
		
		request.setAttribute("search", search);
		request.setAttribute("page", PageContext.getPage());

		PageContext.getPage().setPageSize(ps);
		return "search";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}

