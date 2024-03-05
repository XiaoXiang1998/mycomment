package com.xiang.bean;


public class CommentBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int CommentID;
	private int UserID;
	private String Username;
	private String UserType;
	private String CommentContent;
	private long CommentTime;
	private long lastmodifiedtime;
	private int GoodsId;
	private int rate;
	private int orderID;
	private String ReplyContent;
	private long ReplayTime;
	public int getCommentID() {
		return CommentID;
	}
	public void setCommentID(int commentID) {
		CommentID = commentID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	public String getCommentContent() {
		return CommentContent;
	}
	public void setCommentContent(String commentContent) {
		CommentContent = commentContent;
	}
	public long getCommentTime() {
		return CommentTime;
	}
	public void setCommentTime(long commentTime) {
		CommentTime = commentTime;
	}
	public long getLastmodifiedtime() {
		return lastmodifiedtime;
	}
	public void setLastmodifiedtime(long lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}
	public int getGoodsId() {
		return GoodsId;
	}
	public void setGoodsId(int goodsId) {
		GoodsId = goodsId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public String getReplyContent() {
		return ReplyContent;
	}
	public void setReplyContent(String replyContent) {
		ReplyContent = replyContent;
	}
	public long getReplayTime() {
		return ReplayTime;
	}
	public void setReplayTime(long replayTime) {
		ReplayTime = replayTime;
	}

}
