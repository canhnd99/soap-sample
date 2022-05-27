package com.b2a.soapsample.service;

import ws.vnpost.*;

public interface TrackAndTraceService {
    TrackAndTrace_Items_PublicResponseTrackAndTrace_Items_PublicResult trackAndTraceItemsPublic(String itemCode) throws Exception;

    TrackAndTrace_Items_BCCPResponseTrackAndTrace_Items_BCCPResult trackAndTraceItemsBccp(String itemCode) throws Exception;

    TrackAndTrace_Items_By_DataCode_PublicResponseTrackAndTrace_Items_By_DataCode_PublicResult trackAndTraceItemsByDatacodePublic(String itemCode) throws Exception;

    TrackAndTrace_Items_By_DataCodeResponseTrackAndTrace_Items_By_DataCodeResult trackAndTraceItemsByDatacode(String itemCode) throws Exception;

    TrackAndTrace_Items_ArrResponseTrackAndTrace_Items_ArrResult trackAndTraceItemsArr(String itemCode) throws Exception;

    TrackAndTrace_Items_Arr_LocationResponseTrackAndTrace_Items_Arr_LocationResult trackAndTraceItemsArrLocation(String itemCode) throws Exception;
}
