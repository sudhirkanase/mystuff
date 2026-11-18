package com.tmt.doc.management.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmt.doc.management.dao.beans.DocumentRedisBean;
import com.tmt.doc.management.services.redis.IRedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private IRedisService redisService;

	@GetMapping("/setValue")
	public void setRedisStringValue(@RequestParam("key") String key, @RequestParam("value") String value) {
		redisService.setDcoumentAsString(key, value);
	}

	@GetMapping("/getValue")
	public @ResponseBody ResponseEntity<String> setRedisStringValue(@RequestParam("key") String key) {
		return ResponseEntity.ok(redisService.getDocumentrAsString(key));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/DocumentRedisBean-string")
	public void addProgrammer(@RequestBody DocumentRedisBean DocumentRedisBean) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		redisService.setDcoumentAsString(String.valueOf(DocumentRedisBean.getId()),
				mapper.writeValueAsString(DocumentRedisBean));
	}

	@RequestMapping("/DocumentRedisBean-string/{id}")
	public String readString(@PathVariable String id) {
		return redisService.getDocumentrAsString(id);
	}

	// *******************LIST Demo*******************//

	// add DocumentRedisBean to list
	@RequestMapping(method = RequestMethod.POST, value = "/documents-list")
	public void addToProgrammerList(@RequestBody DocumentRedisBean DocumentRedisBean) {
		redisService.addToDocumentsList(DocumentRedisBean);
	}

	// get all Documents from a list
	@RequestMapping("/Documents-list")
	public List<DocumentRedisBean> getProgrammerListMembers() {
		return redisService.getDocumentsListMembers();
	}

	// count all Documents in a list
	@RequestMapping("/Documents-list/count")
	public Long getProgrammerListCount() {
		return redisService.getDocumentsListCount();
	}

	// *******************SET Demo*******************//

	// add Documents to set
	@RequestMapping(method = RequestMethod.POST, value = "/documents-set")
	public void AddToDocumentstSet(@RequestBody DocumentRedisBean... Documents) {
		redisService.addToDocumentsSet(Documents);
	}

	// get all Documents from a set
	@RequestMapping(method = RequestMethod.GET, value = "/documents-set")
	public Set<DocumentRedisBean> getDocumentsSetMembers() {
		return redisService.getDocumentsSetMembers();
	}

	// Check if DocumentRedisBean already exists in the set
	@RequestMapping(method = RequestMethod.POST, value = "/documents-set/member")
	public boolean isSetMember(@RequestBody DocumentRedisBean documentRedisBean) {
		return redisService.isSetMember(documentRedisBean);
	}

	// *****************HASH Demo**********************//

	// add DocumentRedisBean to hash
	@RequestMapping(method = RequestMethod.POST, value = "/documents-hash")
	public void savePHash(@RequestBody DocumentRedisBean documentRedisBean) {
		redisService.savePHash(documentRedisBean);
	}

	// update DocumentRedisBean in hash
	@RequestMapping(method = RequestMethod.PUT, value = "/documents-hash")
	public void updatePHash(@RequestBody DocumentRedisBean documentRedisBean) {
		redisService.updatePHash(documentRedisBean);
	}

	// get all Documents from hash
	@RequestMapping(method = RequestMethod.GET, value = "/documents-hash")
	public Map<Integer, DocumentRedisBean> FindAllPHash() {
		return redisService.findAllPHash();
	}

	// get DocumentRedisBean from hash
	@RequestMapping(method = RequestMethod.GET, value = "/documents-hash/{id}")
	public DocumentRedisBean FindPInHash(@PathVariable int id) {
		return redisService.findPInHash(id);
	}

	// delete DocumentRedisBean from hash
	@RequestMapping(method = RequestMethod.DELETE, value = "/documents-hash/{id}")
	public void deletePhash(@PathVariable int id) {
		redisService.deletePhash(id);
	}
}
