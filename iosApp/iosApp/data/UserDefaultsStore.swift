import Foundation
import shared

class UserDefaultsStore: KeyValueStore {
	func read(key: String) -> String? {
		return UserDefaults.standard.string(forKey: key)
	}
	
	func write(key: String, value: String) {
		UserDefaults.standard.set(value, forKey: key)
	}
	
	func delete(key: String) {
		UserDefaults.standard.removeObject(forKey: key)
	}
}
