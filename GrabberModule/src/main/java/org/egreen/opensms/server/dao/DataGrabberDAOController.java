package org.egreen.opensms.server.dao;

import org.egreen.opensms.server.entity.GrabberDetails;

import java.text.ParseException;
import java.util.List;


/**
 * Created by Pramoda Fernando on 1/14/2015.
 */
public interface DataGrabberDAOController extends DAOController<GrabberDetails,Long> {
    Integer check_email_validity(String email);

    GrabberDetails login(String username, String password);

    GrabberDetails varify_detail(String varification_code, Long user_id);


    GrabberDetails reset_password(String email);

    GrabberDetails searchGrabberDetailsByEmail(String username);

    GrabberDetails getAllGrabberDetailsByStorageId(String storageId);

    List<GrabberDetails> getAllByNodeIdOrMessageId(String nodeId, Integer limit, Integer offset, Integer type, String firstDate, String secondDate) throws ParseException;
}
