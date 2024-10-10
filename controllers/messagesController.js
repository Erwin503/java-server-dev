const { Message } = require("../models/models");

// Получение всех сообщений
const getMessages = async (req, res) => {
  try {
    const messages = await Message.findAll();
    res.json({ data: messages, message: "Messages retrieved successfully", count: messages.length });
  } catch (error) {
    console.log(error)
    res.status(500).json({ data: null, message: error.message });
  }
};

// Создание нового сообщения
const createMessage = async (req, res) => {
  try {
    const message = await Message.create({...req.body, senderId: req.user.id});
    res.status(201).json({ data: message, message: "Message created successfully" });
  } catch (error) {
    res.status(500).json({ data: null, message: error.message });
  }
};

// Получение сообщения по ID
const getMessageById = async (req, res) => {
  try {
    const message = await Message.findByPk(req.params.id);
    if (message) {
      res.json({ data: message, message: "Message retrieved successfully" });
    } else {
      res.status(404).json({ data: null, message: "Message not found" });
    }
  } catch (error) {
    res.status(500).json({ data: null, message: error.message });
  }
};

// Обновление задачи
const updateMessage = async (req, res) => {
  try {
    const message = await Message.findByPk(req.params.id);
    if (message) {
      await message.update(req.body);
      res.json({ data: message, message: "Message updated successfully" });
    } else {
      res.status(404).json({ data: null, message: "Message not found" });
    }
  } catch (error) {
    res.status(500).json({ data: null, message: error.message });
  }
};

// Удаление сообщения
const deleteMessage = async (req, res) => {
  try {
    const message = await Message.findByPk(req.params.id);
    if (message) {
      await message.destroy();
      res.json({ data: null, message: "Message deleted successfully" });
    } else {
      res.status(404).json({ data: null, message: "Message not found" });
    }
  } catch (error) {
    res.status(500).json({ data: null, message: error.message });
  }
};

// Получение сообщения по user ID
const getMessagesBySender = async (req, res) => {
  try {
    console.log("sender: " + req.params.senderId + "\nrecipient: " + req.user.id)
    const messages = await Message.findAll({
      where: { senderId: req.params.senderId, recipientId: req.user.id },
    });
    res.json({
      data: messages,
      message: "Messages for sender retrieved successfully",
      count: messages.length
    });
  } catch (error) {
    res.status(500).json({ data: null, message: error.message });
  }
};

module.exports = {
  getMessages,
  createMessage,
  getMessageById,
  updateMessage,
  deleteMessage,
  getMessagesBySender,
};
