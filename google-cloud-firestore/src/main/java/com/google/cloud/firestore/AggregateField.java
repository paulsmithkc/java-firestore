package com.google.cloud.firestore;

import javax.annotation.Nonnull;

public class AggregateField {

  private AggregateField() {
  }

  @Nonnull
  public static AggregateField count() {
    return null;
  }

  @Nonnull
  public static AggregateField min(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static AggregateField min(@Nonnull FieldPath field) {
    return null;
  }

  @Nonnull
  public static AggregateField max(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static AggregateField max(@Nonnull FieldPath field) {
    return null;
  }

  @Nonnull
  public static AggregateField average(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static AggregateField average(@Nonnull FieldPath field) {
    return null;
  }

  @Nonnull
  public static AggregateField sum(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static AggregateField sum(@Nonnull FieldPath field) {
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return super.toString();
  }

}

