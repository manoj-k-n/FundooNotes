package com.bridgelabz.fundoonotes.serviceImplemetaion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.Repository.NoteRepository;
import com.bridgelabz.fundoonotes.config.ElasticConfig;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.service.ElasticSerachService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.lang.Arrays;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("unchecked")
public class ElasticSearchServiceImplements implements ElasticSerachService {

	@Autowired
	private ObjectMapper objectmapper;

	@Autowired
	private ElasticConfig config;

	@Autowired
	private NoteRepository noteRepository;

	private static final String INDEX = "bridgelabz";

	private static final String TYPE = "note";

	@Override
	public String createNote(Notes notes) {
		System.out.println("el");
		Map<String, Object> notemapper = objectmapper.convertValue(notes, Map.class);
		IndexRequest indexrequest = new IndexRequest(INDEX, TYPE, String.valueOf(notes.getId())).source(notemapper);
		IndexResponse indexresponse = null;
		System.out.println("hello");

		try {
			indexresponse = config.client().index(indexrequest, RequestOptions.DEFAULT);
			log.info(INDEX, indexresponse);
			System.out.println("welcome");
			return indexresponse.getResult().name();
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}

	}

	public String deleteNote(long noteId) {
		Notes note = noteRepository.findById(noteId);
		DeleteRequest deleterequest = new DeleteRequest(INDEX, TYPE, String.valueOf(note.getId()));
		DeleteResponse deleteResponse = null;
		try {
			deleteResponse = config.client().delete(deleterequest, RequestOptions.DEFAULT);
			return deleteResponse.getResult().name();
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Notes> searchbytitle(String title) {
		SearchRequest searchrequest = new SearchRequest("bridgelabz");
		SearchSourceBuilder searchsource = new SearchSourceBuilder();
		searchsource.query(QueryBuilders.matchQuery("title", title));
		searchrequest.source(searchsource);
		SearchResponse searchresponse = null;
		try {
			searchresponse = config.client().search(searchrequest, RequestOptions.DEFAULT);
			return getResult(searchresponse);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;

	}

	private List<Notes> getResult(SearchResponse searchresponse) {
		try {
			SearchHit[] search = searchresponse.getHits().getHits();
			List<Notes> note = new ArrayList<>();
			if (search.length > 0) {
				Arrays.stream(search)
						.forEach(s -> note.add(objectMapper.convertValue(s.getSourceAsMap(), Notes.class)));
			}
			return note;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateNote(long noteId) {
		Notes note = noteRepository.findById(noteId);
		Map<String, Object> notemapper = objectmapper.convertValue(note, Map.class);
		UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, String.valueOf(note.getId())).doc(notemapper);
		UpdateResponse updateResponse = null;
		try {
			updateResponse = config.client().update(updateRequest, RequestOptions.DEFAULT);
			log.info(updateResponse.getResult().name());
		} catch (IOException e) {
			log.warn(e.getMessage());
		}

	}

}
