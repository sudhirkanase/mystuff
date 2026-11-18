package com.tmt.doc.management.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tmt.doc.management.dao.beans.DocumentRedisBean;

public interface IRedisRepository {

	// String
	void setDocumentAsString(String idKey, String document);

	String getDocumentAsString(String idKey);

	void addToDocumentsList(DocumentRedisBean DocumentRedisBean);

	List<DocumentRedisBean> getDocumentsListMembers();

	Long getDocumentsListCount();

	void addToDocumentsSet(DocumentRedisBean[] Documents);

	Set<DocumentRedisBean> getDocumentsSetMembers();

	boolean isSetMember(DocumentRedisBean DocumentRedisBean);

	void saveHash(DocumentRedisBean DocumentRedisBean);

	void updateHash(DocumentRedisBean DocumentRedisBean);

	Map<Integer, DocumentRedisBean> findAllHash();

	DocumentRedisBean findInHash(int id);

	void deleteHash(int id);

}
