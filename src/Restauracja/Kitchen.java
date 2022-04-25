package Restauracja;

import Enums.Status;
import Units.OrdersManage;
import Units.PersonelManage;

import java.util.Date;

public class Kitchen {

    private final long prepareTime = 30_000;

    private long startedPraparing;
    private long currentTime;
    private long finisTime;

    public void cook() {

        if (!OrdersManage.tableOrderstoCook.isEmpty()) {
            startedPraparing = OrdersManage.tableOrderstoCook.get(0)
                    .getDaty().get(Status.PREPARINGDATE.toString()).getTime();
             currentTime = new Date().getTime();

             finisTime = ((OrdersManage.tableOrderstoCook.get(0).getOrderedItems().size() * prepareTime) /
                    PersonelManage.listaKucharzy.size()) + startedPraparing;

            if (currentTime > finisTime) {
                OrdersManage.tableOrderstoCook.get(0).setStatus(Status.GOTOWE.toString());
                OrdersManage.tableOrderstoCook.get(0).setCookedDate(new Date(finisTime));
                OrdersManage.tableOrderstoPlace.add(OrdersManage.tableOrderstoCook.get(0));
                OrdersManage.tableOrderstoCook.remove(0);
                if (!OrdersManage.tableOrderstoCook.isEmpty()) {
                    OrdersManage.tableOrderstoCook.get(0).setPreparingDate(new Date(finisTime));
                }

            }
        }


    }

}

