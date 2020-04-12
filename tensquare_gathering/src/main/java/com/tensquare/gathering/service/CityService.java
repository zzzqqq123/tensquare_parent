package com.tensquare.gathering.service;


import com.tensquare.gathering.dao.CityDao;
import com.tensquare.gathering.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * city服务层
 * 
 * @author Administrator
 *
 */
@Service
public class CityService {

	@Autowired
	private CityDao cityDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<City> findAll() {
		return cityDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<City> findSearch(Map whereMap, int page, int size) {
		Specification<City> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return cityDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<City> findSearch(Map whereMap) {
		Specification<City> specification = createSpecification(whereMap);
		return cityDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public City findById(String id) {
		return cityDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param city
	 */
	public void add(City city) {
		city.setId( idWorker.nextId()+"" );
		cityDao.save(city);
	}

	/**
	 * 修改
	 * @param city
	 */
	public void update(City city) {
		cityDao.save(city);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		cityDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<City> createSpecification(Map searchMap) {

		return new Specification<City>() {

			@Override
			public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();

				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
