package com.google.cloud.firestore;

import javax.annotation.Nonnull;

public class AggregateField {

  private AggregateField() {
  }

  @Nonnull
  public static CountAggregateField count() {
    return null;
  }

  @Nonnull
  public static MinAggregateField min(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static MinAggregateField min(@Nonnull FieldPath field) {
    return null;
  }

  @Nonnull
  public static MaxAggregateField max(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static MaxAggregateField max(@Nonnull FieldPath field) {
    return null;
  }

  @Nonnull
  public static AverageAggregateField average(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static AverageAggregateField average(@Nonnull FieldPath field) {
    return null;
  }

  @Nonnull
  public static SumAggregateField sum(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static SumAggregateField sum(@Nonnull FieldPath field) {
    return null;
  }

  @Nonnull
  public static LastAggregateField last(@Nonnull String field) {
    return null;
  }

  @Nonnull
  public static LastAggregateField last(@Nonnull FieldPath field) {
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

  public static class CountAggregateField extends AggregateField {
    private CountAggregateField() {
    }

    public CountAggregateField withMaxCount(int maxCount) {
      return null;
    }
  }

  public static class MinAggregateField extends AggregateField {
    private MinAggregateField() {
    }
  }

  public static class MaxAggregateField extends AggregateField {
    private MaxAggregateField() {
    }
  }

  public static class AverageAggregateField extends AggregateField {
    private AverageAggregateField() {
    }
  }

  public static class SumAggregateField extends AggregateField {
    private SumAggregateField() {
    }
  }

  public static class LastAggregateField extends AggregateField {
    private LastAggregateField() {
    }
  }
}

