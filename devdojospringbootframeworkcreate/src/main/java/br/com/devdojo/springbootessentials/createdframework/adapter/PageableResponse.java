package br.com.devdojo.springbootessentials.createdframework.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
/**
 * 
 * @author ferreira
 * @since 09/04/2020
 * @param <T>
 */
public class PageableResponse<T>  extends PageImpl<T>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1086191796618899427L;
	private boolean last;
	private boolean first;
	private int totalPages;
	//For use JSON - default
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PageableResponse(@JsonProperty("content") List<T> content,
                            @JsonProperty("number") int number,
                            @JsonProperty("size") int size,
                            @JsonProperty("totalElements") Long totalElements,
                            @JsonProperty("pageable")JsonNode pageable,
                            @JsonProperty("first") boolean first,
                            @JsonProperty("last") boolean last,
                            @JsonProperty("totalPages") int totalPages,
                            @JsonProperty("sort") JsonNode sort,
                            @JsonProperty("numberOfElements") int numberOfElements){
        super(content, PageRequest.of(number, size), totalElements);
    }
	
	public PageableResponse() {
		super(new ArrayList<>());
	}

	@Override
	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}
	
	@Override
	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	@Override
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
