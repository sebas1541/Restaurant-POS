package presenter;

import model.HotDog;
import model.HotDogManager;
import model.Order;
import views.mainViews.OrderView;

import java.util.List;



    public class OrderPresenter {
        private OrderView view;
        private HotDogManager model;

        public OrderPresenter(OrderView view, HotDogManager model) {
            this.view = view;
            this.model = model;
            populateCenterPanelWithHotDogs();
        }

        private void populateCenterPanelWithHotDogs() {
            List<HotDog> hotDogs = model.getAllHotDogs();
            view.getCenterPanel().populateHotDogs(hotDogs);
        }
    }
