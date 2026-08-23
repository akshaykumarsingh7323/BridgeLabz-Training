package com.fundooapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fundooapp.dto.TagRequest;
import com.fundooapp.dto.TagResponse;
import com.fundooapp.entity.Tag;
import com.fundooapp.entity.User;
import com.fundooapp.exception.TagNotFoundException;
import com.fundooapp.repository.TagRepository;
import com.fundooapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

	private final TagRepository tagRepository;
	private final UserRepository userRepository;

	@Override
	public TagResponse createTag(String email, TagRequest request) {

		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		Tag tag = new Tag();

		tag.setName(request.getName());
		tag.setUser(user);

		Tag savedTag = tagRepository.save(tag);

		return convertToResponse(savedTag);
	}

	@Override
	public List<TagResponse> getAllTags(String email) {

		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		return tagRepository.findByUser(user).stream().map(this::convertToResponse).toList();
	}

	@Override
	public void deleteTag(Long tagId, String email) {

		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		Tag tag = tagRepository.findById(tagId).orElseThrow();

		if (!tag.getUser().getId().equals(user.getId())) {
			throw new TagNotFoundException("Tag not found with id " + tagId);
		}

		tagRepository.delete(tag);
	}

	private TagResponse convertToResponse(Tag tag) {

		return new TagResponse(tag.getId(), tag.getName());
	}
}