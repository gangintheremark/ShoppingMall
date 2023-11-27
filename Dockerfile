FROM amazoncorretto:17

WORKDIR /app

COPY mini-ShoppingMall/build/libs/mini-ShoppingMall-0.0.1-SNAPSHOT.jar /app/shopping-mall.jar
COPY entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh

ENTRYPOINT ["/app/entrypoint.sh"]




