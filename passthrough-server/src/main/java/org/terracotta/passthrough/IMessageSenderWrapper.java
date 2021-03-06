/*
 *
 *  The contents of this file are subject to the Terracotta Public License Version
 *  2.0 (the "License"); You may not use this file except in compliance with the
 *  License. You may obtain a copy of the License at
 *
 *  http://terracotta.org/legal/terracotta-public-license.
 *
 *  Software distributed under the License is distributed on an "AS IS" basis,
 *  WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 *  the specific language governing rights and limitations under the License.
 *
 *  The Covered Software is Entity API.
 *
 *  The Initial Developer of the Covered Software is
 *  Terracotta, Inc., a Software AG company
 *
 */
package org.terracotta.passthrough;

/**
 * An interface used to represent the party who sent a message to a server.
 * This exists so that the core message handling code can work the same way, whether the sender of the message was a client
 * or an active.
 * Specifically, the meaning of different messages is exposed via different methods since some implementations don't want to
 * use the message, only understand why it was sent.
 */
public interface IMessageSenderWrapper {
  default void open() {
    
  }
  void sendAck(PassthroughMessage ack);
  void sendComplete(PassthroughMessage complete, boolean monitor);
  void sendRetire(PassthroughMessage retire);
  PassthroughClientDescriptor clientDescriptorForID(long clientInstanceID);
  /**
   * Used for identifying a PassthroughConnection or anything which wraps one as an IMessageSenderWrapper.  This allows for
   * unique identification of something which represents a client.
   * @return The client origin unique ID.
   */
  long getClientOriginID();
  default void close() {
    
  }
}
