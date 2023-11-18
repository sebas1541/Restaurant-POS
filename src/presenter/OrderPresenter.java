package presenter;

import model.HotDog;
import model.HotDogManager;
import views.mainviews.OrderView;
import views.ownclass.ResizeImage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;



    public class OrderPresenter {
        private OrderView view;
        private HotDogManager model = new HotDogManager();

        public OrderPresenter(OrderView view) {
            this.view = view;
            populateCenterPanelWithHotDogs();
        }

        private void populateCenterPanelWithHotDogs() {
            List<HotDog> hotDogs = model.getAllHotDogs();
            List<HotDogDTO> hotDogDTOs = new ArrayList<>();

            for (HotDog hotDog : hotDogs) {
                ImageIcon itemImage = new ImageIcon(hotDog.getImgFilePath());
                itemImage = new ResizeImage().resize(itemImage, 203, 143);
                hotDogDTOs.add(new HotDogDTO(hotDog.getName(), "$" + hotDog.getPrice(), itemImage));
            }

            view.getCenterPanel().populateHotDogs(hotDogDTOs);
        }


    }
