package kr.or.ddit.command;

public class SearchCriteria extends Criteria {

	private String searchType=""; // 검색구분
	private String keyword=""; //검색어
	private String category=""; //카테고리
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
