package org.egreen.opensms.server.controller;

import org.egreen.opensms.server.entity.*;
import org.egreen.opensms.server.models.*;
import org.egreen.opensms.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by dewmal on 7/17/14.
 */
@Controller
@RequestMapping("fmms/journey/")
public class JourneyController {

    @Autowired
    private DeliveryPointDAOService deliveryPointDAOService;

    @Autowired
    private CustomerOrderDAOService customerOrderDAOService;

    @Autowired
    private CustomerDAOService customerDAOService;

    @Autowired
    private StockPumpingHasDeliveryPointDAOService stockPumpingHasDeliveryPointDAOService;

    @Autowired
    private StockPumpingDetailsDAOService stockPumpingDetailsDAOService;

    @Autowired
    private BargeDAOService bargeDAOService;

    @Autowired
    private TankDAOService tankDAOService;

    @Autowired
    private ShipDAOService shipDAOService;

    @Autowired
    private BowserDAOService bowserDAOService;

    @Autowired
    private CompatmentDAOService compatmentDAOService;

    @Autowired
    private StoreControllerDAOService storeControllerDAOService;

    @Autowired
    private JourneyDAOService journeyDAOService;

    /**
     *
     * Save Journey Order
     *
     * @param journeyOrder
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage saveJourneyOrder(@RequestBody JourneyOrder journeyOrder) {

        System.out.println(journeyOrder);


        Long res = journeyDAOService.save(journeyOrder);

        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }


    /**
     *
     * getAllJourneyOrders
     *
     *
     * @param companyjourneyid
     * @return
     */
    @RequestMapping(value = "getAllJourneyOrders", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllJourneyOrders(@RequestParam("companyjourneyid") Long companyjourneyid) {
        List<JourneyOrder> res = journeyDAOService.getAllJourneyOrders(companyjourneyid);

        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;

    }

    /**
     *
     * getAllJourneyOrderStock
     *
     * @param companyjourneyid
     * @return
     */
    @RequestMapping(value = "getAllJourneyOrderStock", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage getAllJourneyOrderStock(@RequestParam("companyjourneyid") Long companyjourneyid) {
        List<List<StockModel>> listList = new ArrayList<List<StockModel>>();
        List<JourneyOrder> res = journeyDAOService.getAllJourneyOrders(companyjourneyid);
        Map<String, Double> map = new HashMap<String, Double>();
        Double amount = 0.0;
        for (JourneyOrder re : res) {
            amount = map.get(re.getFuelType());
            System.out.println(amount);
            if (amount == null) {
                amount = new Double(0);
            }
            amount += re.getVolume().doubleValue();
            System.out.println(re.getVolume());
            map.put(re.getFuelType(), amount);
        }
        Set<String> fuelTypes = map.keySet();
        List<Compatment> bargecompatmentList = new ArrayList<Compatment>();
        List<Compatment> shipcompatmentList = new ArrayList<Compatment>();
        List<Compatment> bowsercompatmentList = new ArrayList<Compatment>();
        List<Compatment> tankcompatmentList = new ArrayList<Compatment>();

        List<StockModel> bargeList = new ArrayList<StockModel>();
        List<StockModel> shipList = new ArrayList<StockModel>();
        List<StockModel> tankList = new ArrayList<StockModel>();
        List<StockModel> bowserList = new ArrayList<StockModel>();

        for (Iterator<String> iterator = fuelTypes.iterator(); iterator.hasNext(); ) {
            String fuelType = iterator.next();
            bargecompatmentList =  compatmentDAOService.getBargeStockDetailByFuelType(fuelType);
            shipcompatmentList = compatmentDAOService.getShipStockDetailByFuelType(fuelType);
            tankcompatmentList =  compatmentDAOService.getTankStockDetailByFuelType(fuelType);
            bowsercompatmentList =  compatmentDAOService.getBowserStockDetailByFuelType(fuelType);

            for (Compatment compatment : bargecompatmentList) {
                StockModel stockModel = new StockModel();
                stockModel.setCompatment(compatment);
                StoreContainer storeContainer = storeControllerDAOService.getStoreContainerDetailById(compatment.getContainerId());
                stockModel.setStoreContainer(storeContainer);
                bargeList.add(stockModel);
            }
            for (Compatment compatment : shipcompatmentList) {
                StockModel stockModel = new StockModel();
                stockModel.setCompatment(compatment);
                StoreContainer storeContainer = storeControllerDAOService.getStoreContainerDetailById(compatment.getContainerId());
                stockModel.setStoreContainer(storeContainer);
                shipList.add(stockModel);
            }
            for (Compatment compatment : bowsercompatmentList) {
                StockModel stockModel = new StockModel();
                stockModel.setCompatment(compatment);
                StoreContainer storeContainer = storeControllerDAOService.getStoreContainerDetailById(compatment.getContainerId());
                stockModel.setStoreContainer(storeContainer);
                bowserList.add(stockModel);
            }
            for (Compatment compatment : tankcompatmentList) {
                StockModel stockModel = new StockModel();
                stockModel.setCompatment(compatment);
                StoreContainer storeContainer = storeControllerDAOService.getStoreContainerDetailById(compatment.getContainerId());
                stockModel.setStoreContainer(storeContainer);
                tankList.add(stockModel);
            }
        }

        JouneyStockModel jouneyStockModel = new JouneyStockModel();
        jouneyStockModel.setBargelist(bargeList);
        jouneyStockModel.setBowserlist(bowserList);
        jouneyStockModel.setShiplist(shipList);
        jouneyStockModel.setTanklist(tankList);

        ResponseMessage responseMessage;
        if (jouneyStockModel != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(jouneyStockModel);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(jouneyStockModel);
        }
        return responseMessage;
    }


    /**
     *
     * getDeliveryPoints
     *
     * @return
     */
    @RequestMapping(value = "getDeliveryPoints", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getDeliveryPoints() {
        List<DeliveryModel> res = new ArrayList<DeliveryModel>();
        List<Customerorder> allCustomerOrders = customerOrderDAOService.getAllCustomerOrders();
        for (Customerorder allCustomerOrder : allCustomerOrders) {
            DeliveryModel deliveryModel = new DeliveryModel();

            deliveryModel.setCustomerOrderId(allCustomerOrder.getOrderId());
            deliveryModel.setFuelType(allCustomerOrder.getFuelType());
            deliveryModel.setOrderDate(allCustomerOrder.getOrderdate());
            deliveryModel.setVolume(allCustomerOrder.getVolume());
            deliveryModel.setCustomerName(customerDAOService.getCustomerDetailsById(allCustomerOrder.getCustomerId()).getName());

            DeliveryPoint deliveryPoint = deliveryPointDAOService.getOrderDeliveryPoint(allCustomerOrder.getPumpingId());

            DeliveryPointModel deliveryPointModel = new DeliveryPointModel();

            deliveryPointModel.setDetailsId(deliveryPoint.getDetailsId());
            deliveryPointModel.setCustomerId(deliveryPoint.getCustomerId());
            deliveryPointModel.setAddressline1(deliveryPoint.getAddressline1());
            deliveryPointModel.setAddressline2(deliveryPoint.getAddressline2());
            deliveryPointModel.setCity(deliveryPoint.getCity());
            deliveryPointModel.setLabel(deliveryPoint.getLabel());
            deliveryPointModel.setLatitude(deliveryPoint.getLatitude());
            deliveryPointModel.setLongitude(deliveryPoint.getLongitude());

            List<StockPumpingHasDeliveryPoint> pumpingHasDeliveryPoints = stockPumpingHasDeliveryPointDAOService.getStockHasDeliveryPointById(deliveryPoint.getDetailsId());

            List<StockPumpingDetails> stockPumpingDetailsList = new ArrayList<StockPumpingDetails>();
            for (StockPumpingHasDeliveryPoint pumpingHasDeliveryPoint : pumpingHasDeliveryPoints) {
                StockPumpingDetails stockPumpingDetails = stockPumpingDetailsDAOService.getPumpingDetailsById(pumpingHasDeliveryPoint.getStockpumpingdetailsid());
                stockPumpingDetailsList.add(stockPumpingDetails);
            }
            deliveryPointModel.setStockPumpingDetails(stockPumpingDetailsList);
            deliveryModel.setDeliveryPointModel(deliveryPointModel);
            res.add(deliveryModel);
        }
        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     *
     * getAllBargeStocks
     *
     * @return
     */
    @RequestMapping(value = "getAllBargeStocks", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getAllBargeStocks() {
        List<AvailableContainerDetailModel> availableContainerDetailModels = new ArrayList<AvailableContainerDetailModel>();
        List<Barge> allBarges = bargeDAOService.getAllBarges();
        for (Barge allBarge : allBarges) {
            AvailableContainerDetailModel availableBargeModel = new AvailableContainerDetailModel();
            availableBargeModel.setContainerId(allBarge.getBargeId());
            List<Compatment> bargecompatmentList = compatmentDAOService.getAllCompatmentByBargeId(allBarge.getBargeId());
            availableBargeModel.setCompatmentList(bargecompatmentList);

            Map<String, Double> map = new HashMap<String, Double>();
            for (Compatment compatment : bargecompatmentList) {


                Double amount = map.get(compatment.getStockType());
                if (amount == null){
                    amount =  new Double(0);
                }
                amount += compatment.getVolume().doubleValue();
                map.put(compatment.getStockType(),amount);
            }
            availableBargeModel.setTotalVolume(map);
            StoreContainer storeContainer = storeControllerDAOService.getStoreContainerDetailById(allBarge.getBargeId());
            availableBargeModel.setStoreContainer(storeContainer);
            availableContainerDetailModels.add(availableBargeModel);
        }
        ResponseMessage responseMessage;
        if (availableContainerDetailModels != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(availableContainerDetailModels);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(availableContainerDetailModels);
        }
        return responseMessage;
    }


    /**
     *
     * getAllShipStocks
     *
     * @return
     */
    @RequestMapping(value = "getAllShipStocks", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getAllShipStocks() {
        List<AvailableContainerDetailModel> availableContainerDetailModels = new ArrayList<AvailableContainerDetailModel>();
        List<Ship> allShips = shipDAOService.getAllShips();
        for (Ship ship : allShips) {
            AvailableContainerDetailModel availableBargeModel = new AvailableContainerDetailModel();
            availableBargeModel.setContainerId(ship.getShipId());
            List<Compatment> bargecompatmentList = compatmentDAOService.getAllCompatmentByBargeId(ship.getShipId());
            availableBargeModel.setCompatmentList(bargecompatmentList);

            Map<String, Double> map = new HashMap<String, Double>();
            for (Compatment compatment : bargecompatmentList) {
                Double amount = map.get(compatment.getStockType());
                if (amount==null){
                    amount=new Double(0);
                }
                amount+=compatment.getVolume().doubleValue();
                map.put(compatment.getStockType(),amount);
            }
            availableBargeModel.setTotalVolume(map);
            StoreContainer storeContainer = storeControllerDAOService.getStoreContainerDetailById(ship.getShipId());
            availableBargeModel.setStoreContainer(storeContainer);
            availableContainerDetailModels.add(availableBargeModel);
        }
        ResponseMessage responseMessage;
        if (availableContainerDetailModels != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(availableContainerDetailModels);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(availableContainerDetailModels);
        }
        return responseMessage;
    }

    /**
     *
     * getAllTankStocks
     *
     * @return
     */
    @RequestMapping(value = "getAllTankStocks", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getAllTankStocks() {
        List<AvailableContainerDetailModel> availableBargeModelList = new ArrayList<AvailableContainerDetailModel>();
        List<Tank> allTanks = tankDAOService.getAllTanks();
        for (Tank tank : allTanks) {
            AvailableContainerDetailModel availableBargeModel = new AvailableContainerDetailModel();
            availableBargeModel.setContainerId(tank.getTankId());
            List<Compatment> bargecompatmentList = compatmentDAOService.getAllCompatmentByBargeId(tank.getTankId());
            availableBargeModel.setCompatmentList(bargecompatmentList);

            Map<String, Double> map = new HashMap<String, Double>();
            for (Compatment compatment : bargecompatmentList) {
                Double amount = map.get(compatment.getStockType());
                if (amount==null){
                    amount=new Double(0);
                }
                amount+=compatment.getVolume().doubleValue();
                map.put(compatment.getStockType(),amount);
            }
            StoreContainer storeContainer = storeControllerDAOService.getStoreContainerDetailById(tank.getTankId());
            availableBargeModel.setStoreContainer(storeContainer);
            availableBargeModelList.add(availableBargeModel);
        }
        ResponseMessage responseMessage;
        if (availableBargeModelList != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(availableBargeModelList);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(availableBargeModelList);
        }
        return responseMessage;
    }

    /**
     *
     * getAllBowserStocks
     *
     * @return
     */
    @RequestMapping(value = "getAllBowserStocks", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage getAllBowserStocks() {
        List<AvailableContainerDetailModel> availableBargeModelList = new ArrayList<AvailableContainerDetailModel>();
        List<Bowser> allBowsers = bowserDAOService.getAllBowsers();
        for (Bowser bowser : allBowsers) {
            AvailableContainerDetailModel availableBargeModel = new AvailableContainerDetailModel();
            availableBargeModel.setContainerId(bowser.getBowserId());
            List<Compatment> bargecompatmentList = compatmentDAOService.getAllCompatmentByBargeId(bowser.getBowserId());
            availableBargeModel.setCompatmentList(bargecompatmentList);

            Map<String, Double> map = new HashMap<String, Double>();
            for (Compatment compatment : bargecompatmentList) {
                Double amount = map.get(compatment.getStockType());
                if (amount==null){
                    amount=new Double(0);
                }
                amount+=compatment.getVolume().doubleValue();
                map.put(compatment.getStockType(),amount);
            }
            availableBargeModel.setTotalVolume(map);
            StoreContainer storeContainer = storeControllerDAOService.getStoreContainerDetailById(bowser.getBowserId());
            availableBargeModel.setStoreContainer(storeContainer);
            availableBargeModelList.add(availableBargeModel);
        }
        ResponseMessage responseMessage;
        if (availableBargeModelList != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(availableBargeModelList);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(availableBargeModelList);
        }
        return responseMessage;
    }


    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public JourneyOrder getob() {
        return new JourneyOrder();
    }


}
