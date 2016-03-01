/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package cn.riilservice.joint.commons.v2.repository;

import cn.riilservice.joint.commons.v2.entity.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageDao extends PagingAndSortingRepository<Message, Long> {

}
