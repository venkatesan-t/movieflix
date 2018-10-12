package com.venkat.movieflixwebapi.lib;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;


public class CassandraConnector {

    private static CassandraConnector single_instance = null;

    private Cluster cluster;

    private Session session;

    private CassandraConnector()
    {

    }

    public static CassandraConnector getInstance()
    {
        if(single_instance == null)
        {
            single_instance = new CassandraConnector();
        }
        return single_instance;
    }

    public void connect(final String node, final int port)
    {
        this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
        final Metadata metadata = cluster.getMetadata();
        System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
        for (final Host host : metadata.getAllHosts())
        {
            System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n",
                    host.getDatacenter(), host.getAddress(), host.getRack());
        }
        session = cluster.connect();
    }

    public Session getSession()
    {
        return this.session;
    }

    public void close()
    {
        session.close();
    }
}
