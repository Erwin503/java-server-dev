const express = require("express");
const router = express.Router();
const messagesController = require("../controllers/messagesController.js");
const checkRole = require("../middleware/checkRole");
const authenticate = require("../middleware/authenticate");

router.get(
  "/",
  authenticate,
  checkRole("Admin"),
  messagesController.getMessages
);

router.post("/", authenticate, messagesController.createMessage);

router.get(
  "/:id",
  authenticate,
  checkRole("Admin"),
  messagesController.getMessageById
);

router.put("/:id", authenticate, messagesController.updateMessage);

router.delete("/:id", authenticate, messagesController.deleteMessage);

router.get(
  "/sender/:senderId",
  authenticate,
  messagesController.getMessagesBySender
);

module.exports = router;
