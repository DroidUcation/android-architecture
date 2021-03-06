/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.data.source;

import android.support.annotation.NonNull;

import com.example.android.architecture.blueprints.todoapp.data.Task;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Main entry point for accessing tasks data.
 * <p>
 */
public interface TasksDataSource {
    default Single<List<Task>> getTasks(boolean forceUpdate) {
        if (forceUpdate) refreshTasks();
        return getTasks();
    }

    Single<List<Task>> getTasks();

    Single<Task> getTask(@NonNull String taskId);

    Completable saveTask(@NonNull Task task);

    Completable completeTask(@NonNull Task task);

    void completeTask(@NonNull String taskId);

    Completable activateTask(@NonNull Task task);

    void activateTask(@NonNull String taskId);

    Completable clearCompletedTasks();

    void refreshTasks();

    void deleteAllTasks();

    void deleteTask(@NonNull String taskId);
}
