package com.javarush.lectures.rest_example.service;

import com.javarush.lectures.rest_example.model.Client;

import java.util.List;

public interface ClientService {

    /**
     * Создаёт нового клиента
     * @param client - клиент для создания
     */

    void create(Client client);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return - объект клиента с заданным ID
     */

    List<Client> readAll();

    /**
     * Возвращает клиента по ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */

    Client read(int id);

    /**
     * Обновляет клиента с заданным ID
     * в соответствии с переданным клиентом
     * @param client - клиент в соответствии с которым нужно обновить данные
     * @param id - ID клиента которого нужно обновить
     * @return - true если данные обновлены, иначе false
     */

    boolean update(Client client, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - ID клиента, которого нужно удалить
     * @return - true, если клиент был удалён, иначе false
     */

    boolean delete(int id);
}
