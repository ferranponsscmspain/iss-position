package com.ferranpons.issposition.issTracking;

import io.reactivex.Observable;

public class IssTrackingInteractor implements IssTrackingInteractorInterface {
  private final IssTrackingApiInterface api;

  public IssTrackingInteractor(IssTrackingApiInterface api) {
    this.api = api;
  }

  @Override
  public Observable<IssTrackingApiInterface.CurrentPositionResponse> getCurrentPosition() {
    //return api.getCurrentPosition();
    return Observable.empty();
  }

  @Override
  public Observable<IssTrackingApiInterface.PassTimesResponse> getPassTimes(double latitude,
      double longitude) {
    //return api.getPassTimes(latitude, longitude);
    return Observable.empty();
  }

  @Override
  public Observable<IssTrackingApiInterface.PeopleInSpaceResponse> getPeopleInSpace() {
    //return api.getPeopleInSpace();
    return Observable.empty();
  }
}
