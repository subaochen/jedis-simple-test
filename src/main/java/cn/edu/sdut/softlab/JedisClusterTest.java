package cn.edu.sdut.softlab;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by subaochen on 17-5-1.
 */
public class JedisClusterTest {
    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6381));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value = jc.get("foo");
        System.out.println("foo = " + value);
        jc.hset("site","dev","{'id':100,'name':'test','value':12.45}");
        value = jc.hget("site","dev");
        System.out.println("site = " + value);
    }
}
