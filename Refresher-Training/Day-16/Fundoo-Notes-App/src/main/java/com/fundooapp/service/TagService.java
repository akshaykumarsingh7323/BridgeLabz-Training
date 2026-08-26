package com.fundooapp.service;

import java.util.List;

import com.fundooapp.dto.TagRequest;
import com.fundooapp.dto.TagResponse;

public interface TagService {

	TagResponse createTag(String email, TagRequest request);

	List<TagResponse> getAllTags(String email);

	void deleteTag(Long tagId, String email);
}