/**
 * CELINE SCORM
 *
 * Copyright 2014 Adilson Vahldick.
 * https://celine-scorm.googlecode.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.univali.celine.scorm2004_4th.model.cam;

public class AdlcpMap {

	private String targetID;
	private boolean readSharedData = true;
	private boolean writeSharedData = true;
	
	public String getTargetID() {
		return targetID;
	}
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}
	public boolean isReadSharedData() {
		return readSharedData;
	}
	public void setReadSharedData(boolean readSharedData) {
		this.readSharedData = readSharedData;
	}
	public boolean isWriteSharedData() {
		return writeSharedData;
	}
	public void setWriteSharedData(boolean writeSharedData) {
		this.writeSharedData = writeSharedData;
	}
	
	
	
}
