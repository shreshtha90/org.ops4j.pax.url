package org.apache.maven.repository;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.List;

/**
 * @author Benjamin Bentmann
 */
public class CollectRequest
{

    // we have three types of collection regarding the request:
    // 1. root-only, e.g. a plugin declaration, resolve the root and its transitive closure
    // 2. root-with-children, e.g. a plugin declaration with project-level deps, merge children
    // 3. children-only, e.g. the (managed) dependencies of a project, don't resolve root but only its transitive
    // closure

    private Dependency root;

    private List<Dependency> dependencies;

    private List<Dependency> managedDependencies;

    private List<RemoteRepository> repositories;

    public CollectRequest()
    {
        // enables default constructor
    }

    public CollectRequest( Dependency root, List<RemoteRepository> repositories )
    {
        setRoot( root );
        setRepositories( repositories );
    }

    public Dependency getRoot()
    {
        return root;
    }

    public CollectRequest setRoot( Dependency root )
    {
        this.root = root;
        return this;
    }

    public List<Dependency> getDependencies()
    {
        return dependencies;
    }

    public CollectRequest setDependencies( List<Dependency> dependencies )
    {
        this.dependencies = dependencies;
        return this;
    }

    public List<Dependency> getManagedDependencies()
    {
        return managedDependencies;
    }

    public CollectRequest setManagedDependencies( List<Dependency> managedDependencies )
    {
        this.managedDependencies = managedDependencies;
        return this;
    }

    public List<RemoteRepository> getRepositories()
    {
        return repositories;
    }

    public CollectRequest setRepositories( List<RemoteRepository> repositories )
    {
        this.repositories = repositories;
        return this;
    }

}
