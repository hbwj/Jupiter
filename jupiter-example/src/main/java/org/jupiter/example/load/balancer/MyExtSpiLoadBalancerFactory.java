/*
 * Copyright (c) 2015 The Jupiter Project
 *
 * Licensed under the Apache License, version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jupiter.example.load.balancer;

import org.jupiter.rpc.load.balance.ExtSpiLoadBalancerFactory;
import org.jupiter.rpc.load.balance.LoadBalancer;

/**
 * jupiter
 * org.jupiter.example.load.balancer
 *
 * @author jiachun.fjc
 */
public class MyExtSpiLoadBalancerFactory implements ExtSpiLoadBalancerFactory {

    private static final MySingletonLoadBalancer singletonLoadBalancer = new MySingletonLoadBalancer();

    @Override
    public LoadBalancer getInstance(String name) {
        if ("MySingletonLoadBalancer".equals(name)) {
            return singletonLoadBalancer;
        } else if ("MyPrototypeLoadBalancer".equals(name)) {
            return new MyPrototypeLoadBalancer();
        }
        return new MyLoadBalancer();
    }
}