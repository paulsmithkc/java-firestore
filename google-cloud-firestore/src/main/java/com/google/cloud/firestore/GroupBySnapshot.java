package com.google.cloud.firestore;

import com.google.cloud.Timestamp;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public interface GroupBySnapshot extends Iterable<AggregateSnapshot> {

  @Nonnull
  GroupByQuery getQuery();

  // Question: Is the read time meaningful for an aggregate snapshot?
  @Nonnull
  Timestamp getReadTime();

  @Nonnull
  List<AggregateSnapshot> getGroups();

  boolean isEmpty();

  int size();

  @Override
  @Nonnull
  Iterator<AggregateSnapshot> iterator();

  // Question: Are we going to support custom object mapping/converters?
  @Nonnull
  <T> List<T> toObjects(@Nonnull Class<T> clazz);

  @Override
  boolean equals(Object obj);

  @Override
  int hashCode();
}
