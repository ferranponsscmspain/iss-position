package com.ferranpons.spacehub.issTracking;

import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface IssTrackingApiInterface {
  @GET("/iss-now.json")
  Observable<CurrentPositionResponse> getCurrentPosition();

  @GET("/iss-pass.json")
  Observable<PassTimesResponse> getPassTimes(@Query("lat") double latitude,
      @Query("lon") double longitude);

  @GET("/astros.json")
  Observable<PeopleInSpaceResponse> getPeopleInSpace();

  class PeopleInSpaceResponse {
    @SerializedName("message") String message;

    @SerializedName("number") int number;

    @SerializedName("people") List<Person> people;
  }

  class Person {
    @SerializedName("name") public String name;

    @SerializedName("craft") public String spaceCraft;
  }

  class CurrentPositionResponse {
    @SerializedName("message") String message;

    @SerializedName("timestamp") long timestamp;

    @SerializedName("iss_position") IssPosition position;
  }

  class IssPosition {
    @SerializedName("latitude") public double latitude;

    @SerializedName("longitude") public double longitude;
  }

  class PassTimesResponse {
    @SerializedName("message") String message;

    @SerializedName("request") RequestPassTimes request;

    @SerializedName("response") List<PassTime> passTimes;
  }

  class RequestPassTimes {
    @SerializedName("latitude") double latitude;

    @SerializedName("longitude") double longitude;

    @SerializedName("altitude") long altitude;

    @SerializedName("passes") int passes;

    @SerializedName("datetime") long datetime;
  }

  class PassTime {
    @SerializedName("risetime") public long riseTime;

    @SerializedName("duration") public int duration;
  }
}
