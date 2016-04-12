package com.ctrip.apollo.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrip.apollo.biz.entity.Cluster;
import com.ctrip.apollo.biz.repository.ClusterRepository;
import com.ctrip.apollo.biz.utils.BeanUtils;

@Service
public class ClusterService {

  @Autowired
  private ClusterRepository clusterRepository;

  public Cluster findOne(String appId, String name) {
    return clusterRepository.findByAppIdAndName(appId, name);
  }

  public Cluster save(Cluster entity) {
    return clusterRepository.save(entity);
  }

  public void delete(long id) {
    clusterRepository.delete(id);
  }

  public Cluster update(Cluster cluster) {
    Cluster managedCluster =
        clusterRepository.findByAppIdAndName(cluster.getAppId(), cluster.getName());
    BeanUtils.copyEntityProperties(cluster, managedCluster);
    return clusterRepository.save(managedCluster);
  }
}
