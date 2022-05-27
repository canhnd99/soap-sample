package com.b2a.soapsample.service;

import org.apache.axis.message.SOAPHeaderElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ws.vnpost.*;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

@Service
public class TrackAndTraceServiceImpl implements TrackAndTraceService {
    @Value("${vnpost.url}")
    private String wsUrl;

    @Value("${vnpost.user}")
    private String username;

    @Value("${vnpost.pass}")
    private String password;

    @Value("${vnpost.namespaceURI}")
    private String namespaceURI;

    public TrackAndTrace_Items_PublicResponseTrackAndTrace_Items_PublicResult trackAndTraceItemsPublic(String itemCode) throws Exception {
        TrackAndTraceSoap trackAndTraceSoap = getTrackAndTrackSoap(Const.TRACK_AND_TRACE_METHODS.TRACK_AND_TRACE_ITEMS_PUBLIC);
        return trackAndTraceSoap.trackAndTrace_Items_Public(itemCode);
    }

    public TrackAndTrace_Items_BCCPResponseTrackAndTrace_Items_BCCPResult trackAndTraceItemsBccp(String itemCode) throws Exception {
        TrackAndTraceSoap trackAndTraceSoap = getTrackAndTrackSoap(Const.TRACK_AND_TRACE_METHODS.TRACK_AND_TRACE_ITEMs_BCCP);
        return trackAndTraceSoap.trackAndTrace_Items_BCCP(itemCode);
    }

    public TrackAndTrace_Items_By_DataCode_PublicResponseTrackAndTrace_Items_By_DataCode_PublicResult trackAndTraceItemsByDatacodePublic(String itemCode) throws Exception {
        TrackAndTraceSoap trackAndTraceSoap = getTrackAndTrackSoap(Const.TRACK_AND_TRACE_METHODS.TRACK_AND_TRACE_ITEMs_BY_DATACODE_PUBLIC);
        return trackAndTraceSoap.trackAndTrace_Items_By_DataCode_Public(itemCode);
    }

    public TrackAndTrace_Items_By_DataCodeResponseTrackAndTrace_Items_By_DataCodeResult trackAndTraceItemsByDatacode(String itemCode) throws Exception {
        TrackAndTraceSoap trackAndTraceSoap = getTrackAndTrackSoap(Const.TRACK_AND_TRACE_METHODS.TRACK_AND_TRACE_ITEMs_BY_DATACODE);
        return trackAndTraceSoap.trackAndTrace_Items_By_DataCode(itemCode);
    }

    public TrackAndTrace_Items_ArrResponseTrackAndTrace_Items_ArrResult trackAndTraceItemsArr(String itemCode) throws Exception {
        TrackAndTraceSoap trackAndTraceSoap = getTrackAndTrackSoap(Const.TRACK_AND_TRACE_METHODS.TRACK_AND_TRACE_ITEMs_ARR);
        return trackAndTraceSoap.trackAndTrace_Items_Arr(itemCode);
    }

    public TrackAndTrace_Items_Arr_LocationResponseTrackAndTrace_Items_Arr_LocationResult trackAndTraceItemsArrLocation(String itemCode) throws Exception {
        TrackAndTraceSoap trackAndTraceSoap = getTrackAndTrackSoap(Const.TRACK_AND_TRACE_METHODS.TRACK_AND_TRACE_ITEMs_ARR_LOCATION);
        return trackAndTraceSoap.trackAndTrace_Items_Arr_Location(itemCode);
    }

    private TrackAndTraceSoap getTrackAndTrackSoap(String method) throws ServiceException {
        TrackAndTraceLocator serviceImp_service = new TrackAndTraceLocator(wsUrl, getQName(method));
        serviceImp_service.setTrackAndTraceSoapEndpointAddress(wsUrl);

        TrackAndTraceSoap trackAndTraceSoap = serviceImp_service.getTrackAndTraceSoap();
        setHeader(trackAndTraceSoap);
        return trackAndTraceSoap;
    }

    private void setHeader(TrackAndTraceSoap trackAndTraceSoap) {
        ((TrackAndTraceSoapStub) trackAndTraceSoap).setHeader(new SOAPHeaderElement("user", username));
        ((TrackAndTraceSoapStub) trackAndTraceSoap).setHeader(new SOAPHeaderElement("pass", password));
    }

    private QName getQName(String localPart){
        return new QName(namespaceURI, localPart);
    }
}
