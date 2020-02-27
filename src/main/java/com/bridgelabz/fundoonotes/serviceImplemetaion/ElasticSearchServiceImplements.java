package com.bridgelabz.fundoonotes.serviceImplemetaion;

import java.io.IOException;
import java.util.Map;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.config.ElasticConfig;
import com.bridgelabz.fundoonotes.model.Notes;
import com.bridgelabz.fundoonotes.service.ElasticSerachService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@SuppressWarnings("unchecked")
public class ElasticSearchServiceImplements implements ElasticSerachService
{
	
	@Autowired 
	private ObjectMapper objectmapper;
	
	@Autowired
	private ElasticConfig config;
	
	private static final String INDEX="bridgelabz";
	
	private static final String TYPE="note";
	
@Override
public String createNote(Notes notes) {
	System.out.println("el");
	Map<String,Object> notemapper=objectmapper.convertValue(notes,Map.class);
	IndexRequest indexrequest=new  IndexRequest(INDEX,TYPE,String.valueOf(notes.getId())).source(notemapper);
	IndexResponse indexresponse=null;
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
}
